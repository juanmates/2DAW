import { Component } from '@angular/core';
import { PostsService } from '../services/postsService';
import { Observable } from 'rxjs';
import { PostModel } from '../../model/PostModel';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-post',
  imports: [AsyncPipe],
  templateUrl: './post.html',
  styleUrl: './post.css',
})
export class Post {
  posts = new Observable<PostModel[]>;
  constructor(private servicio: PostsService){}
  getTabla() {
    this.posts = this.servicio.getPosts();
  }
}
