import { Observable } from 'rxjs';
import { PostsService } from '../services/posts-service';
import { PostsModel } from './../model/posts';
import { Component, OnInit } from '@angular/core';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-posts',
  imports: [AsyncPipe],
  templateUrl: './posts.html',
  styleUrl: './posts.css',
})
export class Posts {

  posts = new Observable<PostsModel[]>();

  constructor (private postService: PostsService) {}

  mostrarLista() {
    this.posts = this.postService.getPosts();
  }


}
