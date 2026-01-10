import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-post',
  imports: [FormsModule, CommonModule],
  templateUrl: './post.html'
})
export class PostComponent {
  posts: any[] = [];

  constructor(private http: HttpClient) {}

  cargarPosts() {
    this.http.get<any[]>('https://jsonplaceholder.typicode.com/posts')
      .subscribe(data => this.posts = data);
  }
}
