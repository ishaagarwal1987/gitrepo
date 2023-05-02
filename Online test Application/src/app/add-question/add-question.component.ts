import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AddquesService } from '../addques.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css']
})
export class AddQuestionComponent implements OnInit {

  msg:string="";

  constructor(
    private router: Router,
    private builder: FormBuilder,
    private quesService:AddquesService
  ) { }

  ngOnInit(): void {
  }

  quesForm = this.builder.group({
    ques : this.builder.control('', Validators.required),
    option1 : this.builder.control('',Validators.required),
    option2 : this.builder.control('',Validators.required),
    option3 : this.builder.control('',Validators.required),
    option4 : this.builder.control('',Validators.required),
    ans : this.builder.control('',Validators.required),
  });

  addQuestion()
  {
    this.quesService.saveQuestion(this.quesForm.value).subscribe(data=>{
      this.msg="Question Added Successfully";
    });
    this.quesForm.reset;
  }

}
