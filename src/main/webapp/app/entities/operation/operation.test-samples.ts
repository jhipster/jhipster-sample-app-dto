import dayjs from 'dayjs/esm';

import { IOperation, NewOperation } from './operation.model';

export const sampleWithRequiredData: IOperation = {
  id: 19024,
  date: dayjs('2015-08-04T14:48'),
  amount: 21142.67,
};

export const sampleWithPartialData: IOperation = {
  id: 3246,
  date: dayjs('2015-08-04T23:07'),
  amount: 1445.78,
};

export const sampleWithFullData: IOperation = {
  id: 27203,
  date: dayjs('2015-08-04T16:50'),
  description: 'keenly righteously worth',
  amount: 19564.27,
};

export const sampleWithNewData: NewOperation = {
  date: dayjs('2015-08-05T06:49'),
  amount: 10016.1,
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
