import { Component, OnInit } from '@angular/core';
import { delay } from 'rxjs/operators';
import { SpinnerService } from 'src/app/core/services/spinner.service';


@Component({
  selector: 'app-spinner', 
  template: `<div class="progress-spinner" *ngIf="isLoading">
  <p-progressSpinner></p-progressSpinner>
</div>`,
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit  {

  isLoading : boolean = false; 

  constructor( private spinnerService : SpinnerService ) {}



  ngOnInit() {
    this.listenToLoading();
  }

  
  listenToLoading(): void {
    this.spinnerService.loadingSub
      .pipe(delay(0)) // Este delay previene una ExpressionChangedAfterItHasBeenCheckedError
      .subscribe((loading) => {
        this.isLoading = loading;
      });

      
  }
  


 
}
