import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'bank-account',
        loadChildren: () => import('./bank-account/bank-account.module').then(m => m.JhipsterDtoSampleApplicationBankAccountModule),
      },
      {
        path: 'label',
        loadChildren: () => import('./label/label.module').then(m => m.JhipsterDtoSampleApplicationLabelModule),
      },
      {
        path: 'operation',
        loadChildren: () => import('./operation/operation.module').then(m => m.JhipsterDtoSampleApplicationOperationModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class JhipsterDtoSampleApplicationEntityModule {}
