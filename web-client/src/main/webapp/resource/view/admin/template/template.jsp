<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword"
          content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>Admin</title>

    <!-- Bootstrap core CSS -->
    <link href="${contextPath}/resource/view/admin/themes/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resource/view/admin/themes/css/bootstrap-reset.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${contextPath}/resource/view/admin/themes/css/style.css" rel="stylesheet">
    <link href="${contextPath}/resource/view/admin/themes/css/style-responsive.css" rel="stylesheet"/>
    <!--Nhat -->
    <link href="${contextPath}/resource/view/admin/themes/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${contextPath}/resource/view/admin/themes/assets/advanced-datatable/media/css/demo_page.css" rel="stylesheet" />
    <link href="${contextPath}/resource/view/admin/themes/assets/advanced-datatable/media/css/demo_table.css" rel="stylesheet" />
</head>

<body>

<section id="container" class="">
    <tiles:insertAttribute name="header"/>
    <aside>
        <tiles:insertAttribute name="sidebar"/>
        <tiles:insertAttribute name="body"/>
    </aside>
    <tiles:insertAttribute name="footer"/>
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="${contextPath}/resource/view/admin/themes/js/jquery-1.8.3.min.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
        src="${contextPath}/resource/view/admin/themes/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/jquery.scrollTo.min.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${contextPath}/resource/view/admin/themes/js/respond.min.js"></script>

<!--common script for all pages-->
<script src="${contextPath}/resource/view/admin/themes/js/common-scripts.js"></script>

<!-- Nhat -->
<!--<script src="js/jquery.js"></script>-->
<script type="text/javascript" language="javascript" src="${contextPath}/resource/view/admin/themes/assets/advanced-datatable/media/js/jquery.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="${contextPath}/resource/view/admin/themes/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/jquery.scrollTo.min.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${contextPath}/resource/view/admin/themes/js/respond.min.js" ></script>
<script type="text/javascript" language="javascript" src="${contextPath}/resource/view/admin/themes/assets/advanced-datatable/media/js/jquery.dataTables.js"></script>


<!--common script for all pages-->
<script src="${contextPath}/resource/view/admin/themes/js/common-scripts.js"></script>
<script src="${contextPath}/resource/view/admin/themes/js/editable-table.js"></script>
</body>
</html>
<script type="text/javascript">
    jQuery.noConflict();
    /* Formating function for row details */
    function fnFormatDetails ( oTable, nTr )
    {
        var aData = oTable.fnGetData( nTr );
        var sOut = '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">';
        sOut += '<tr><td>Rendering engine:</td><td>'+aData[1]+' '+aData[4]+'</td></tr>';
        sOut += '<tr><td>Link to source:</td><td>Could provide a link here</td></tr>';
        sOut += '<tr><td>Extra info:</td><td>And any further details here (images etc)</td></tr>';
        sOut += '</table>';
        return sOut;
    }

    jQuery (document).ready(function($) {
        /*
         * Insert a 'details' column to the table
         */
        var nCloneTh = document.createElement( 'th' );
        var nCloneTd = document.createElement( 'td' );
        nCloneTd.innerHTML = '<img src="${contextPath}/resource/view/admin/themes/assets/advanced-datatable/examples/examples_support/details_open.png">';
        nCloneTd.className = "center";

        $('#hidden-table-info thead tr').each( function () {
            this.insertBefore( nCloneTh, this.childNodes[0] );
        } );

        $('#hidden-table-info tbody tr').each( function () {
            this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
        } );

        /*
         * Initialse DataTables, with no sorting on the 'details' column
         */
        var oTable = $('#hidden-table-info').dataTable( {
            "aoColumnDefs": [
                { "bSortable": false, "aTargets": [ 0 ] }
            ],
            "aaSorting": [[1, 'asc']]
        });

        /* Add event listener for opening and closing details
         * Note that the indicator for showing which row is open is not controlled by DataTables,
         * rather it is done here
         */
        $('#hidden-table-info tbody td img').live('click', function () {
            var nTr = $(this).parents('tr')[0];
            if ( oTable.fnIsOpen(nTr) )
            {
                /* This row is already open - close it */
                this.src = "${contextPath}/resource/view/admin/themes/assets/advanced-datatable/examples/examples_support/details_open.png";
                oTable.fnClose( nTr );
            }
            else
            {
                /* Open this row */
                this.src = "${contextPath}/resource/view/admin/themes/assets/advanced-datatable/examples/examples_support/details_close.png";
                oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
            }
        } );
    } );
</script>

<script type="text/javascript" >
    $(function() {
        $("#editForm").validate({

            rules: {
                username: "required",
                address: "required",
                phone:{
                    required: true,
                    // pattern: true
                },
                birthday:{
                    required : true
                },
                email: {
                    required: true,
                    email: true
                },
                password: {
                    required: true,
                    minlength: 5,
                    maxlength: 20
                }

            },

            // Specify the validation error messages
            messages: {
                username: "Please enter your username",
                address: "Please enter your address",
                birthday:"Please enter your birthay",
                phone:{
                    required: "Please provide a phone",
                    //  pattern:"\d{3}[\-]\d{3}[\-]\d{4}"
                },
                password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 5 characters long",
                    maxlength: "Your password must be at least than 20 characters long"
                },

                email: "Please enter a valid email address",
            },

            submitHandler: function(form) {
                form.submit();
            }
        });

    });

</script>