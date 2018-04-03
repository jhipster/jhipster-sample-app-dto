import { IOperation } from './operation.model';

export interface IBankAccount {
  id?: number;
  name?: string;
  balance?: number;
  userLogin?: string;
  userId?: number;
  operations?: IOperation[];
}

export class BankAccount implements IBankAccount {
  constructor(
    public id?: number,
    public name?: string,
    public balance?: number,
    public userLogin?: string,
    public userId?: number,
    public operations?: IOperation[]
  ) {}
}
