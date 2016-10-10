<%@ include file="include/header.jsp" %>

<!-- start: Header -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="/dic/add${suffix}"><span>Metro</span></a>

            <!-- start: Header Menu -->
            <div class="nav-no-collapse header-nav">
                <ul class="nav pull-right">
                    <li>
                        <a class="btn" href="#">
                            <i class="halflings-icon white wrench"></i>
                        </a>
                    </li>
                    <!-- start: User Dropdown -->
                    <li class="dropdown">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="halflings-icon white user"></i>
                            ${currentUser.nickName}
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-title">
                                <span>设置</span>
                            </li>
                            <li><a href="#"><i class="halflings-icon user"></i>个人信息</a></li>
                            <li><a href="${ctx}${adminPath}/logout${suffix}"><i class="halflings-icon off"></i> Logout</a></li>
                        </ul>
                    </li>
                    <!-- end: User Dropdown -->
                </ul>
            </div>
            <!-- end: Header Menu -->

        </div>
    </div>
</div>
<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <c:forEach items="${menus}" var="menu">
                        <li>
                            <c:choose>
                                <c:when test="${not empty menu.child}">
                                    <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> ${menu.displayName}</span></a>
                                    <ul>
                                        <c:forEach items="${menu.child}" var="child">
                                            <li><a class="submenu" href="${ctx}${child.url}${suffix}"><i class="icon-file-alt"></i><span class="hidden-tablet"> ${child.displayName}</span></a></li>
                                        </c:forEach>
                                    </ul>
                                </c:when>
                                <c:otherwise>
                                    <a href="${ctx}${menu.url}"><i class="icon-bar-chart"></i><span class="hidden-tablet"> ${menu.displayName}</span>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <!-- end: Main Menu -->

    </div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>

<%@ include file="include/footer.jspf" %>
