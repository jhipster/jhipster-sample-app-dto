import { BaseEntity } from './../../shared';

export class BankAccount implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
        public balance?: number,
        public userLogin?: string,
        public userId?: number,
        public operations?: BaseEntity[],
    ) {
    }
}
