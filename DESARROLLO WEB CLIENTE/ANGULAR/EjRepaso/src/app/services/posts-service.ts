import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PostsModel } from '../model/posts';

@Injectable({
  providedIn: 'root',
})
export class PostsService {
  private url: string = 'https://jsonplaceholder.typicode.com/posts';
  constructor(private httpClient: HttpClient) {}

  getPosts() {
    return this.httpClient.get<PostsModel[]>(this.url);
  }
}
