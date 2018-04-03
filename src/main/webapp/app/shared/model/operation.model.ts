import { Moment } from 'moment';
import { ILabel } from './label.model';

export interface IOperation {
  id?: number;
  date?: Moment;
  description?: string;
  amount?: number;
  bankAccountName?: string;
  bankAccountId?: number;
  labels?: ILabel[];
}

export class Operation implements IOperation {
  constructor(
    public id?: number,
    public date?: Moment,
    public description?: string,
    public amount?: number,
    public bankAccountName?: string,
    public bankAccountId?: number,
    public labels?: ILabel[]
  ) {}
}
