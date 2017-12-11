import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { JhipsterDtoSampleApplicationBankAccountModule } from './bank-account/bank-account.module';
import { JhipsterDtoSampleApplicationLabelModule } from './label/label.module';
import { JhipsterDtoSampleApplicationOperationModule } from './operation/operation.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        JhipsterDtoSampleApplicationBankAccountModule,
        JhipsterDtoSampleApplicationLabelModule,
        JhipsterDtoSampleApplicationOperationModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterDtoSampleApplicationEntityModule {}
