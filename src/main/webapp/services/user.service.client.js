function AdminUserServiceClient() {
  this.createUser = createUser;
  this.findUserById = findUserById;
  this.findAllUsers = findAllUsers;
  this.deleteUser = deleteUser;
  this.updateUser = updateUser;
  this.url = 'https://wbdv-generic-server.herokuapp.com/api/yaqinzhou/users';
  function findAllUsers() {
    return fetch(this.url)
      .then(response => response.json())
  }

  function findUserById(userId) {  }

  function createUser(user) {
    return fetch(this.url, {
      method: 'POST',
      body: JSON.stringify(user),
      headers: {
        'content-type': 'application/json'
      }
    })
      .then(response => response.json())
  }
  function updateUser(userId, user) {
    return fetch(this.url + '/' + userId, {
      method: 'PUT',
      body: JSON.stringify(user),
      headers: {
        'content-type': 'application/json'
      }
    })
  }
  function deleteUser(userId) {
    return fetch(this.url+ '/' + userId, {
      method: 'DELETE'
    })
  }
}
