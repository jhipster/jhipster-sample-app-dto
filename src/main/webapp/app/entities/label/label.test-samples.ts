import { ILabel, NewLabel } from './label.model';

export const sampleWithRequiredData: ILabel = {
  id: 23058,
  label: 'thoughtfully jubilantly describe',
};

export const sampleWithPartialData: ILabel = {
  id: 26682,
  label: 'within soon oof',
};

export const sampleWithFullData: ILabel = {
  id: 25118,
  label: 'in celebrate',
};

export const sampleWithNewData: NewLabel = {
  label: 'whoever gripper scent',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
