import { Component, OnInit } from '@angular/core';
import { AddquesService } from '../addques.service';

@Component({
  selector: 'app-admin-welcome',
  templateUrl: './admin-welcome.component.html',
  styleUrls: ['./admin-welcome.component.css']
})
export class AdminWelcomeComponent implements OnInit {

  questions:any =[];
  constructor(private quesService : AddquesService) { }

  ngOnInit(): void {
    this.getQuestions();
  }

  getQuestions()
  {
    this.quesService.getQuestions().subscribe(data=>{
      this.questions=data;
    });
  }
}
