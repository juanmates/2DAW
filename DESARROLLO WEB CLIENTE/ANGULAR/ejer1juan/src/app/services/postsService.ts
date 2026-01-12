import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PostModel } from '../../model/PostModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PostsService {

  URL: string = "https://jsonplaceholder.typicode.com/posts";

  constructor(private http: HttpClient){};

  getPosts(): Observable<PostModel[]> {
    return this.http.get<PostModel[]>(this.URL);
  }

}
