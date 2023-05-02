export class ResultAnalysis {
    questionId:number;
    selectedAns:string;
    correctAns:string;

    constructor(quesId:number,optedAns:string,actualAns:string)
    {
        this.questionId=quesId;
        this.selectedAns=optedAns;
        this.correctAns=actualAns;
    }    
}
