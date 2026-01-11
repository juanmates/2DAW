import { Component, OnInit } from '@angular/core';
import { SuperheroeService } from '../services/superheroe-service';
import { Observable } from 'rxjs';
import { Squad } from '../model/Squad';
import { AsyncPipe, CommonModule } from '@angular/common';

@Component({
  selector: 'app-superheroes',
  imports: [AsyncPipe, CommonModule],
  templateUrl: './superheroes.html',
  styleUrl: './superheroes.css',
})
export class Superheroes implements OnInit {

  constructor(private service:SuperheroeService) { }

  squad$ = new Observable<Squad>();

  ngOnInit(): void {

    this.squad$ = this.service.getSuperheroes();

  }



}
