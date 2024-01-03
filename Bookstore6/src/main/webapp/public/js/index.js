/**
 * 
 */

const checkAcceptRules = () => {
	const acceptRules = document.getElementById('acceptRules')
	const submit = document.getElementById('submit')
	console.log(acceptRules, submit)
	if(acceptRules.checked) {
		submit.style.visibility = 'visible'
	} else {
		submit.style.visibility = 'hidden'
	}
}

const checkPassword = () => {
	const password = document.getElementById('password').value
	const passwordConfirm = document.getElementById('passwordConfirm').value
	const errorPassMessage = document.getElementById('errorPass');
	
	if(password !== passwordConfirm) {
		errorPassMessage.innerHTML = 'Mật khẩu không trùng khớp!';
	} else {
		errorPassMessage.innerHTML = '';
	}
}