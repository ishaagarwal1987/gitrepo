import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComplaintEmployeePageComponent } from './complaint-employee-page.component';

describe('ComplaintEmployeePageComponent', () => {
  let component: ComplaintEmployeePageComponent;
  let fixture: ComponentFixture<ComplaintEmployeePageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ComplaintEmployeePageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ComplaintEmployeePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
