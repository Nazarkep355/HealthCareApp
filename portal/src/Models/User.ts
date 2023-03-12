import { each } from 'lodash';

export interface IUserServerModel {
  id: number;
  email: string | null;
  password: string | null;
  firstName: string | null;
  secondName: string | null;
  role: string | null;
}

export default class User implements IUserServerModel {

  constructor(model?: IUserServerModel) {
    if (model) {
      const root = this;
      each(root, (value, key) => {
        root[key] = model[key];
      });
    }
  }
  public id: number = null;
  public email: string = null;
  public password: string = null;
  public firstName: string = null;
  public secondName: string = null;
  public role: string = null;

}