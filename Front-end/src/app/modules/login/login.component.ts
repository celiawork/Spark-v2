import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { BehaviorSubject, map, Observable } from 'rxjs';
import { User } from 'src/app/shared/models/user';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form!: FormGroup;
  isLoggedIn : boolean = false;
  sendForm: boolean = true;
  errorMessage : string = " ";


  constructor(private authservice: AuthService, private router: Router, private tokenservice: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenservice.getToken()) {
      this.isLoggedIn = true;
    }

    this.form = new FormGroup({
      username: new FormControl(null, [Validators.required, Validators.pattern("^([a-zA-Z0-9-._]+)@([A-Za-z-]+)\.([a-z]{2,3}(.[a-z]{2,3})?)$")]),
      password: new FormControl(null, [Validators.required, Validators.minLength(8)])
    })
  }

  get password() { return this.form.get('password'); }
  get username() { return this.form.get('username'); }


  loginUser() {
    if (this.form.invalid) {
      this.sendForm = false;
      return;
    }else {
      this.sendForm = true;
    }

    console.log( this.sendForm);
    
    this.authservice.signIn(this.form.get('username')?.value, this.form.get('password')?.value).subscribe({
      next: (res) => {

        this.tokenservice.saveToken(res.acces_token);
        this.tokenservice.saveUser(res);
        this.isLoggedIn = true;
        console.log('je suis la reponse' + JSON.stringify(res.acces_token));
      },
  
      error: (err: any) => { 
        this.errorMessage = "L'email ou le mot de passe est incorrectes"
        console.log(err.error.message);
        this.isLoggedIn = false;
        throw err.message;
      },

      complete: () => { 
        this.router.navigateByUrl('/home')
      }
    }
    )

  }

}



