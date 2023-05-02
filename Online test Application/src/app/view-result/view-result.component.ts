import { Component, OnInit } from '@angular/core';
import { ResultService } from '../services/result.service';
import { Result } from '../result';

@Component({
  selector: 'app-view-result',
  templateUrl: './view-result.component.html',
  styleUrls: ['./view-result.component.css']
})
export class ViewResultComponent implements OnInit {

  results:any = [];
  resultData:any =[];
  userId:string;
  constructor(private resultService: ResultService) { }

  ngOnInit(): void {
    this.userId=sessionStorage.getItem("userId");
    this.getResult();
  }

  getResult()
  {
    this.resultService.getResult(this.userId).subscribe(data=>{
      this.results = data;
     
    });

    

  }


}
