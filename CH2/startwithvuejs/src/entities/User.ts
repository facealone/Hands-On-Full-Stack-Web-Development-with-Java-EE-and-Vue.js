import { Role } from '../entities/Role'

export class User {
    private _name: string;
    private _email: string;
    private _password: string;
    private _role: Role;
    constructor (name: string, email: string, password: string, role: Role) {
      this._name = name
      this._email = email
      this._password = password
      this._role = role
    }
    get name () {
      return this._name
    }
    get email () {
      return this._email
    }
    get password () {
      return this._password
    }
    get role () {
      return this._role
    }
}
