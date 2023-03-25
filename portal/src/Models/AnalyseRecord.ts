import { each } from 'lodash';
import MedicalTopic from './MedicalTopic';
import Subject from './Subject';
import User from './User';

interface Author {
    id:number;
    user: User;
    medicalTopic: MedicalTopic
};

export interface IAnalyseRecordServerModel {
  id: number;
  name: string | null;
  subject: Subject;
  result: string;
  date: number;
  author: Author,
  user: User;
}

export default class AnalyseRecord implements IAnalyseRecordServerModel {

  constructor(model?: IAnalyseRecordServerModel) {
    if (model) {
      const root = this;
      each(root, (value, key) => {
        root[key] = model[key];
      });
    }
  }
  public id: number = null;
  public name: string = null;
  public subject: Subject = null;
  public result: string = null;
  public date: number = null;
  public author: Author = null;
  public user: User = null;
}