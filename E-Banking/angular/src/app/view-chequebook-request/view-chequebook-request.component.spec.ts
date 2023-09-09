import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewChequebookRequestComponent } from './view-chequebook-request.component';

describe('ViewChequebookRequestComponent', () => {
  let component: ViewChequebookRequestComponent;
  let fixture: ComponentFixture<ViewChequebookRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewChequebookRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewChequebookRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
