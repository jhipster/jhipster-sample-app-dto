import { IUser } from './user.model';

export const sampleWithRequiredData: IUser = {
  id: 32243,
  login: 'b_D3qr',
};

export const sampleWithPartialData: IUser = {
  id: 31625,
  login: '0',
};

export const sampleWithFullData: IUser = {
  id: 12966,
  login: 'V|n@FZYfEM\\}poaqG\\h2d\\&KYY\\Pk0kM\\dsoWTv-',
};
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
