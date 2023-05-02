import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminWelcomeComponent } from './admin-welcome/admin-welcome.component';
import { AddQuestionComponent } from './add-question/add-question.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { UserWelcomeComponent } from './user-welcome/user-welcome.component';
import { QuizComponent } from './quiz/quiz.component';
import { ViewUsersComponent } from './view-users/view-users.component';
import { ViewResultComponent } from './view-result/view-result.component';

const routes: Routes = [
  {path:"", component:LoginComponent},
  {path:"login", component:LoginComponent},
  {path:"adminWelcome", component:AdminWelcomeComponent},
  {path:"addquestion",component:AddQuestionComponent},
  {path:"regUser",component:RegisterUserComponent},
  {path:"userWelcome",component:UserWelcomeComponent},
  {path:"quiz",component:QuizComponent},
  {path:"viewUsers",component:ViewUsersComponent},
  {path:"viewResult",component:ViewResultComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
