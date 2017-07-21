<%--
  Created by IntelliJ IDEA.
  User: victor
  Date: 20/07/2017
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="robots" content="index, follow"/>
    <meta name="generator" content="RapidWeaver"/>

    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width">
    <meta name="baseurl" content="/index.html">

    <title><%out.println(request.getAttribute("title"));%> | MyBlog | My Website</title>

    <link rel="stylesheet" type="text/css" media="all"
          href="../rw_common/themes/offroad/consolidated.css?rwcache=521897748"/>


    <link href="https://fonts.googleapis.com/css?family=Istok+Web:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400italic,700,700italic" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="../rw_common/themes/offroad/assets/javascript/html5shiv.js"></script>
    <script src="../rw_common/themes/offroad/assets/javascript/respond.js"></script>
    <![endif]-->


    <link rel="alternate" type="application/rss+xml" title="My RSS Feed" href="../files/feed.xml"/>
    <script type="text/javascript" async src="../files/meta.js"></script>


</head>

<body>
<div id="page" class="site">
    <a class="sr-only sr-only-focusable" href="#content">Skip to main content</a>

    <nav class="site-navigation" role="navigation">
        <div class="row">
            <div class="col-xs-12">
                <div class="site-navigation-inner">
                    <ul>
                        <li class="selected"><a href="../" rel="" class="current">MyBlog</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav><!-- .site-navigation -->

    <header id="masthead" class="site-header" role="banner">
        <div class="container">
            <div class="site-branding">
                <div class="site-title">
                    <a href="/index.html">My Website</a>
                </div>

                <div class="site-logo">
                    <a href="/index.html" class="site-logo"></a>
                </div>

                <div class="site-description">
                    Changing the world, one site at a time&hellip;
                </div>
            </div><!-- .site-branding -->
        </div><!-- .container -->
    </header><!-- .site-header -->

    <div class="container container-main">
        <div class="row">
            <main id="content" class="site-content col-xs-12 col-md-9" role="main">
                <div class="site-content-inner">

                    <div class="blog-archive-entries-wrapper">
                        <div id="unique-entry-id-0" class="blog-entry">
                            <h1 class="blog-entry-title">
                                <% out.println(request.getAttribute("title")); %></h1>
                            <%--<% out.println(request.getAttribute("title"));%></h1>--%>
                            <div class="blog-entry-date">16/07/17 19:23</div>
                            <div class="blog-entry-body">
                                <% out.println(request.getAttribute("content")); %>
                            </div>
                        </div>
                    </div>


                </div>
            </main>

            <aside class="site-sidebar col-xs-12 col-md-3">
                <div class="sidebar">

                </div>

                <div class="plugin-sidebar"></div>
            </aside>
        </div>
    </div>

    <footer id="footer" class="site-footer" role="contentinfo">
        <div class="row">
            <div class="col-xs-12">
                &copy; 2017 Victor Liu
            </div>
        </div>
    </footer>
</div>

<div class="body-overlay"></div>

<!-- Javascript includes -->
<script src="../rw_common/themes/offroad/javascript.js?rwcache=521897748"></script>
<script type="text/javascript"
        src="../rw_common/themes/offroad/assets/javascript/background-blur.js?rwcache=521897748"></script>
<script type="text/javascript"
        src="../rw_common/themes/offroad/assets/javascript/sidebar-right.js?rwcache=521897748"></script>

</body>
</html>