import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '09775ecb-991f-49ed-ae33-713c8906d9eb',
};

export const sampleWithPartialData: IAuthority = {
  name: '6b42e922-1cae-4604-ab6d-165effda5c0a',
};

export const sampleWithFullData: IAuthority = {
  name: '74622a67-b493-4a67-ad9e-9daba07d1130',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
