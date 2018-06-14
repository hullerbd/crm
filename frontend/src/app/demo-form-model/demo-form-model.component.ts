import { FormGroup, FormControl, FormBuilder, FormArray, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo-form-model',
  templateUrl: './demo-form-model.component.html',
  styleUrls: ['./demo-form-model.component.css']
})
export class DemoFormModelComponent implements OnInit {
  langs: string[] = [
    'English',
    'French',
    'German',
  ];
  myform: FormGroup;
  constructor(private fb: FormBuilder) {
  }
  ngOnInit() {
    // choose one of them to bind form
    // (1)
    // this.bindForm();

    // (2)
    this.createForm();
  }

  bindForm() {
    this.myform = new FormGroup({
      name: new FormGroup({
        firstName: new FormControl('', Validators.required),
        lastName: new FormControl('', Validators.required),
      }),
      email: new FormControl('', Validators.email),
      password: new FormControl(),
      language: new FormControl()
    });
  }

  createForm() {
    this.myform = this.fb.group({
      name: this.fb.group({
        firstName: ['', Validators.required],
        lastName: ['', Validators.required]
      }),
      email: ['', Validators.email],
      password: '',
      language: ''
    });
  }

  onSubmit(f) {
    console.log(f.value);
    if (f.valid) {
      console.log('This form is good to go.');
    }

  }
}
