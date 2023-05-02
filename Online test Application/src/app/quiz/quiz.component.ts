import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AddquesService } from '../addques.service';
import { Observable } from 'rxjs';
import { FormBuilder, Validators } from '@angular/forms';
import { ResultAnalysis } from '../result-analysis';
import { ResultService } from '../services/result.service';
import { Result } from '../result';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css']
})
export class QuizComponent implements OnInit {

  submittedAns: any = [];
  questionsList: any = [];
  currentQuestion: number = 0;
  counter = 60;
  marks: number = 0;
  correctAns: number = 0;
  inCorrectAns: number = 0;
  isQuizCompleted: boolean = false;
  totalMarks: number;
  radioStatus: boolean;
  ansListUpdated: boolean = false;
  msg: string = "";
  username:string;
  userId:string;

  constructor(
    private router: Router,
    private builder: FormBuilder,
    private quesService: AddquesService,
    private resultService : ResultService
    
  ) { }

  ngOnInit(): void {
    this.displayQuiz();
    this.userId=sessionStorage.getItem("userId");
    this.username = sessionStorage.getItem("userdetails");
  }

  displayQuiz() {
    this.quesService.getQuestions().subscribe(data => {
      this.questionsList = data;
    });


  }

  nextQuestion() {
    this.radioStatus = false;
    if (this.currentQuestion < this.questionsList.length - 1) {
      this.currentQuestion++;
      
    }
    else {
      for (var i in this.submittedAns) {
        if(this.submittedAns[i].selectedAns == this.submittedAns[i].correctAns)
          this.correctAns++;
        else
          this.inCorrectAns++;
      }
      this.marks=this.correctAns*2;
      this.totalMarks = this.questionsList.length * 2;
      this.isQuizCompleted = true;

      this.resultService.saveResult(new Result(this.userId,new Date().toLocaleDateString(),this.marks+"/"+this.totalMarks)).subscribe(data=>{
      
      });

    }
  }

  previousQuestion() {
    this.currentQuestion--;
    this.radioStatus = false;
  }

  submitAns(currQno: number, optedAns: string) {
    this.ansListUpdated = false;

    for (var i in this.submittedAns) {
      if (this.submittedAns[i].questionId == this.questionsList[currQno].id) {
        this.submittedAns[i].selectedAns = optedAns;
        this.ansListUpdated = true;
        break;
      }
    }
    if (!this.ansListUpdated)
      this.submittedAns.push(new ResultAnalysis(this.questionsList[currQno].id, optedAns, this.questionsList[currQno].ans));

    //if(optedAns==this.questionsList[currQno].ans)
    //{
    //  this.correctAns++;

    //}
    // else
    // this.inCorrectAns++;
  }

  checkAnswer(currQno: number, selectedOption: any) {
    if (currQno == this.questionsList.length) {
      this.isQuizCompleted = true;
    }
    if (selectedOption == this.questionsList[currQno].ans) {
      this.marks += 2;
      this.correctAns++;
    }
    else {
      this.inCorrectAns++;
    }

  }

  resetQuiz() {
    this.displayQuiz();
    this.currentQuestion = 0;
    this.marks = 0;
    this.correctAns = 0;
    this.inCorrectAns = 0;
    this.isQuizCompleted = false;
  }
}
