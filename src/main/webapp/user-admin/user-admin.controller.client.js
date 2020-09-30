(function () {

  let container
  let users
  let tbody
  let template
  let clone
  let $createBtn
  let $usernameFld, $firstNameFld, $lastNameFld, $roleFld, $passwordFld
  const userService = new AdminUserServiceClient()


  let selectedUserIndex = -1
  const selectUser = (index) => {
    selectedUserIndex = index
    $("#usernameFld").val(users[index].username)
    $("#firstNameFld").val(users[index].first)
    $("#lastNameFld").val(users[index].last)
    $("#roleFld").val(users[index].role)
    $("#passwordFld").val(users[index].password)
  }


  const renderUsers = (users) => {
    tbody.empty()
    const ul = $("<ul>")
    for (let i = 0; i < users.length; i++) {
      const user = users[i]
      clone = template.clone()
      clone.removeClass("wbdv-hidden")

      clone.find(".wbdv-username").html(user.username)
      clone.find(".wbdv-first-name").html(user.first)
      clone.find(".wbdv-last-name").html(user.last)
      clone.find(".wbdv-role").html(user.role)
      clone.find(".wbdv-remove").click(() => deleteUser(i))
      clone.find(".wbdv-edit").click(() => selectUser(i))

      tbody.append(clone)
    }
     container.append(ul)
  }

  const deleteUser = (_index) => {
    const user = users[_index]
    const userId = user._id
    userService.deleteUser(userId)
      .then(response => {
        users.splice(_index, 1)
        renderUsers(users)
      })
  }

  const createUser = () => {
    const username = $usernameFld.val()
    const firstName = $firstNameFld.val()
    const lastName = $lastNameFld.val()
    const password = $passwordFld.val()
    const role = $roleFld.val()

    $usernameFld.val("")
    $firstNameFld.val("")
    $lastNameFld.val("")
    $roleFld.val("")
    $passwordFld.val("")

    const newUser = {
      username: username,
      first: firstName,
      last: lastName,
      role: role,
      password: password
    }
    userService.createUser(newUser)
      .then(actualNewUser => {
        users.push(actualNewUser)
        renderUsers(users)
      })
  }

  const updateUser = () => {
    const newUsername = $("#usernameFld").val()
    const newFirstName = $("#firstNameFld").val()
    const newLastName = $("#lastNameFld").val()
    const newRole = $("#roleFld").val()
    const newPassword = $("#passwordFld").val()
    const userId = users[selectedUserIndex]._id

    $usernameFld.val("")
    $firstNameFld.val("")
    $lastNameFld.val("")
    $roleFld.val("")
    $passwordFld.val("")

    userService.updateUser(userId, {
      username: newUsername,
      first: newFirstName,
      last: newLastName,
      role: newRole,
      password: newPassword
    }).then(response => {
        users[selectedUserIndex].username = newUsername
        users[selectedUserIndex].first = newFirstName
        users[selectedUserIndex].last = newLastName
        users[selectedUserIndex].role = newRole
        users[selectedUserIndex].password = newPassword
        renderUsers(users)
      })
  }

  const findAllUsers = () => {
    userService.findAllUsers()
    .then((_users) => {
      users = _users
      renderUsers(users)
    })
  }


  const main = () => {


    const heading1 = jQuery("h1")
    heading1
      .html("User Administrator")

    container = $(".container")
    tbody = $("tbody")
    template = $("tr.wbdv-template")
    $createBtn = $(".wbdv-create").click(createUser)
    $firstNameFld = $("#firstNameFld")
    $usernameFld = $("#usernameFld")
    $lastNameFld = $("#lastNameFld")
    $roleFld = $("#roleFld")
    $passwordFld = $("#passwordFld")
    $(".wbdv-update").click(updateUser)

    findAllUsers()
  }
  $(main)


})()
