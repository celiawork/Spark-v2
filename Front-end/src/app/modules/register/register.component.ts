import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Role } from 'src/app/shared/models/role';
import { AuthService } from 'src/app/shared/services/auth/auth.service';
import { TokenStorageService } from 'src/app/shared/services/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form!: FormGroup;
  sendForm: boolean = true;
  isSuccessful: boolean = false;
  title: string = "Bienvenue";
  token!: string;
  msgerrors!: string;
  sub!: Subscription;

  constructor(private authService: AuthService, private tokenservice: TokenStorageService) { }

  /**
   * Set of FormControl to validate the form 
   */
  ngOnInit(): void {
    this.form = new FormGroup({
      firstname: new FormControl(null, Validators.required),
      lastname: new FormControl(null, Validators.required),
      username: new FormControl(null, [Validators.required,
      Validators.pattern("^([a-zA-Z0-9-._]+)@([A-Za-z-]+)\.([a-z]{2,3}(.[a-z]{2,3})?)$")]),
      password: new FormControl(null, [Validators.required, Validators.minLength(8)])
    })
  }

  get firstname() { return this.form.get('firstname'); }
  get lastname() { return this.form.get('lastname'); }
  get password() { return this.form.get('password'); }
  get username() { return this.form.get('username'); }

  /**
   * Register of user
   */
  registerUser(): void {
    if (this.form.invalid) {
      this.msgerrors = "Merci de remplir tous les champs";
      return;
    } else {
      this.sub = this.authService.register(this.form.get('firstname')?.value, this.form.get('lastname')?.value, this.form.get('username')?.value, this.form.get('password')?.value).subscribe({
        next: (res) => {
          this.isSuccessful = true;
          this.token = res;
        },
        error: (err: any) => {
          console.log(err.error.message);
          this.msgerrors = "une erreur s'est produite";
          throw err.message;
        },
        complete: () => {
          this.title = "Attente de confirmation"
        }
      });
      
    }
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }
}