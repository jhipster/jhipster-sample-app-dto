import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import {
  JhipsterDtoSampleApplicationSharedLibsModule,
  JhipsterDtoSampleApplicationSharedCommonModule,
  JhiLoginModalComponent,
  HasAnyAuthorityDirective
} from './';

@NgModule({
  imports: [JhipsterDtoSampleApplicationSharedLibsModule, JhipsterDtoSampleApplicationSharedCommonModule],
  declarations: [JhiLoginModalComponent, HasAnyAuthorityDirective],
  entryComponents: [JhiLoginModalComponent],
  exports: [JhipsterDtoSampleApplicationSharedCommonModule, JhiLoginModalComponent, HasAnyAuthorityDirective],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class JhipsterDtoSampleApplicationSharedModule {
  static forRoot() {
    return {
      ngModule: JhipsterDtoSampleApplicationSharedModule
    };
  }
}
