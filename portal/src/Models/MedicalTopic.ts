import { each } from 'lodash';

export interface IMedicalTopicServerModel {
  id: number;
  name: string | null;
}

export default class MedicalTopic implements IMedicalTopicServerModel {

  constructor(model?: IMedicalTopicServerModel) {
    if (model) {
      const root = this;
      each(root, (value, key) => {
        root[key] = model[key];
      });
    }
  }
  public id: number = null;
  public name: string = null;
}