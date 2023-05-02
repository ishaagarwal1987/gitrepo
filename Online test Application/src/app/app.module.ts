import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserWelcomeComponent } from './user-welcome/user-welcome.component';
import { QuizComponent } from './quiz/quiz.component';
import { ViewUsersComponent } from './view-users/view-users.component';
import { ViewResultComponent } from './view-result/view-result.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminWelcomeComponent,
    AddQuestionComponent,
    RegisterUserComponent,
    UserWelcomeComponent,
    QuizComponent,
    ViewUsersComponent,
    ViewResultComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    ReactiveFormsModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
