from django.contrib.admin import AdminSite

class MyAdminSite(AdminSite):
    site_header = "🌟 YesMadam Admin Panel 🌟"
    site_title = "YesMadam Admin"
    index_title = "Welcome to YesMadam Admin Dashboard"

admin_site = MyAdminSite(name='myadmin')

from .models import Item  # import your models
admin_site.register(Item)
