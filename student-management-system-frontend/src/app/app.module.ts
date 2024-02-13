// src/app/app.module.ts

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component'; // Import other components as needed
import { ApiService } from './api.service'; // Import other services as needed

@NgModule({
  declarations: [AppComponent, StudentListComponent], // Include other components here
  imports: [BrowserModule, HttpClientModule, RouterModule, AppRoutingModule],
  providers: [ApiService], // Include other services here
  bootstrap: [AppComponent],
})
export class AppModule {}
