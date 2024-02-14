// src/app/app.module.ts

import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { ApiService } from './api.service'; // Import other services as needed
import { AppComponent } from './app.component';
import { routes } from './app.routes';
import { StudentListComponent } from './student-list/student-list.component'; // Import other components as needed

@NgModule({
  declarations: [AppComponent, StudentListComponent], // Include other components here
  imports: [BrowserModule, HttpClientModule, RouterModule, routes],
  providers: [ApiService], // Include other services here
  bootstrap: [AppComponent],
})
export class AppModule {}
