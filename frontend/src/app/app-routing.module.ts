import { CwTodolistComponent } from './cw-todolist/cw-todolist.component';
import { DemoHtmlcssComponent } from './demo-htmlcss/demo-htmlcss.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { DemoHttpclientComponent } from './demo-httpclient/demo-httpclient.component';
import { DemoRxjsComponent } from './demo-rxjs/demo-rxjs.component';
import { DemoFormModelComponent } from './demo-form-model/demo-form-model.component';
import { DemoFormTemplateComponent } from './demo-form-template/demo-form-template.component';
import { DemoDatabindComponent } from './demo-databind/demo-databind.component';
import { DemoTypescriptComponent } from './demo-typescript/demo-typescript.component';


import { DemoDatashareComponent } from './demo-datashare/demo-datashare.component';
import { DemoPipeComponent } from './demo-pipe/demo-pipe.component';
import { DemoDirectiveBuildinComponent } from './demo-directive-buildin/demo-directive-buildin.component';
import { DemoDirectiveAttributeComponent } from './demo-directive-attribute/demo-directive-attribute.component';
import { DemoDirectiveStructuralComponent } from './demo-directive-structural/demo-directive-structural.component';
import { DemoRoutingParametersComponent } from './demo-routing-parameters/demo-routing-parameters.component';
import { CwFinancialToolComponent } from './cw-financial-tool/cw-financial-tool.component';

const routes: Routes = [
  { path: '', redirectTo: '', pathMatch: 'full' },
  { path: 'HtmlCss', component: DemoHtmlcssComponent },
  { path: 'Typescript', component: DemoTypescriptComponent },
  { path: 'RxJS', component: DemoRxjsComponent },
  { path: 'DataBind', component: DemoDatabindComponent },
  { path: 'DataShare', component: DemoDatashareComponent },
  { path: 'Pipe', component: DemoPipeComponent },
  { path: 'RoutingParameter/:productType/:productId', component: DemoRoutingParametersComponent },
  {
    path: 'Directive', children: [
      { path: 'DirectiveBuildin', component: DemoDirectiveBuildinComponent },
      { path: 'DirectiveStructural', component: DemoDirectiveStructuralComponent },
      { path: 'DirectiveAttribute', component: DemoDirectiveAttributeComponent }
    ]
  },
  {
    path: 'Form', children: [
      { path: 'FormTemplate', component: DemoFormTemplateComponent },
      { path: 'FormModel', component: DemoFormModelComponent }
    ]
  },
  { path: 'HttpClient', component: DemoHttpclientComponent },
  {
    path: 'CourseWork', children: [
      { path: 'FinancialTool', component: CwFinancialToolComponent },
      { path: 'TodoList', component: CwTodolistComponent }
    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
