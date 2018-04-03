import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterDtoSampleApplicationSharedModule } from 'app/shared';
import { JhipsterDtoSampleApplicationAdminModule } from 'app/admin/admin.module';
import {
  BankAccountService,
  BankAccountComponent,
  BankAccountDetailComponent,
  BankAccountUpdateComponent,
  BankAccountDeletePopupComponent,
  BankAccountDeleteDialogComponent,
  bankAccountRoute,
  bankAccountPopupRoute,
  BankAccountResolve
} from './';

const ENTITY_STATES = [...bankAccountRoute, ...bankAccountPopupRoute];

@NgModule({
  imports: [JhipsterDtoSampleApplicationSharedModule, JhipsterDtoSampleApplicationAdminModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    BankAccountComponent,
    BankAccountDetailComponent,
    BankAccountUpdateComponent,
    BankAccountDeleteDialogComponent,
    BankAccountDeletePopupComponent
  ],
  entryComponents: [BankAccountComponent, BankAccountUpdateComponent, BankAccountDeleteDialogComponent, BankAccountDeletePopupComponent],
  providers: [BankAccountService, BankAccountResolve],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterDtoSampleApplicationBankAccountModule {}
