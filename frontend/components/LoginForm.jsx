import {Formik, Field, Form} from 'formik';
import axios from 'axios';

const LoginForm = () => {

    return (
        <div>
            <p>Login Selector</p>
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
                    });
                }}
            >
                <Form>
                    <Field id="username" name="username" placeholder="Username" />
                    <Field id="password" name="password" placeholder="Password" />
                    <button type="submit"><Link to="/landing">Submit</Link></button>
                </Form>
            </Formik>


            
        </div>
    )
}

export default LoginForm;