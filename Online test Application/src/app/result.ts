export class Result {
    userid:string;
    testDate:string;
    marks:string;

    constructor(userid:string,examDate:string,points:string)
    {
        this.userid = userid;
        this.testDate = examDate;
        this.marks = points;
    }
}
