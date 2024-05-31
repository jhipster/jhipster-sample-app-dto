import { IAuthority, NewAuthority } from './authority.model';

export const sampleWithRequiredData: IAuthority = {
  name: '0b937974-54e6-4c6b-b698-9e1ff196ebdd',
};

export const sampleWithPartialData: IAuthority = {
  name: '53132701-c34c-4d81-b9c0-061de9be3be9',
};

export const sampleWithFullData: IAuthority = {
  name: '62bb4d2c-e091-4272-a81a-ceaee5680f42',
};

export const sampleWithNewData: NewAuthority = {
  name: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
