import {Formik, Field, Form} from 'formik';
import axios from 'axios';

const Login = () => {

    return (
        <div>
            <p>Login</p>
            <Formik 
                initialValues={{
                    username: '',
                    password: '',
                }}
                onSubmit={values => {
                    console.log(values);
                    axios.post('/api/login', {
                        username: values.username,
                        password: values.password
                    }).then(res => {
                        console.log(`response: ${res.data}`);
                        // if (res == "Success") 
                        //Route
                    });
                }}
            >
                <Form>
                    <Field id="username" name="username" placeholder="Username" />
                    <Field id="password" name="password" placeholder="Password" />
                    <button type="submit">Submit</button>
                </Form>
            </Formik>
        </div>
    )
}

export default Login;