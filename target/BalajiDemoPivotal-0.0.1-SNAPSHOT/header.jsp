<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"/>
<link href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/css/bootstrapvalidator.min.css" rel="stylesheet"/>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
<style type="text/css">
	body {
		padding: 10px;
	}
</style>
<!-- Document ready funciton -->
<script type="text/javascript">
jQuery(document).ready(function() {
    jQuery('.num-converter').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	number: {
                message: 'It is not valid Number',
                validators: {
                    notEmpty: {
                        message: 'Number field is required and cannot be empty'
                    },
                    stringLength: {
                        min: 1,
                        max: 10,
                        message: 'The Number must be more than 1 and less than 10 characters long'
                    },
                    regexp: {
                        regexp: /^^(\d+\.?\d{0,2}|\.\d{1,2})$/,
                        message: 'Only valid numbers with maximum of 2 decimals allowed'
                    }
                }
            }
        }
    });
});
</script>