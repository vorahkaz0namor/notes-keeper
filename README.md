## Свойства классов и параметры функций, которые указаны в [исходной структуре](https://dev.vk.com/method/notes), но не включены в данный проект с целью его упрощения:

> **_1. класс Note:_**
> 
> - read_comments
> - view_url
> - privacy_view
> - text_wiki

> **_2. класс Comment:_**
>
> - donut
> - attachments
> - parents_stack
> - thread

> **_3. функция add():_**
>
> - privacy
> - comment_privacy
> - privacy_view
> - privacy_comment

> **_4. функция createComment():_**
>
> - owner_id
> - guid

> **_5. функция deleteComment():_**
>
> - owner_id

> **_6. функция edit():_**
>
> - privacy
> - comment_privacy
> - privacy_view
> - privacy_comment

> **_7. функция editComment():_**
>
> - owner_id

> **_8. функция get():_**
>
> - note_ids
> - offset
> - count

> **_9. функция getById():_**
>
> - owner_id
> - need_wiki

> **_10. функция getComments():_**
>
> - owner_id
> - offset
> - count

> **_11. функция getFriendsNotes()_**
>
> исключена полностью в связи с рекомендацией сайта:
> "Данный метод устарел и может быть отключён через некоторое время, пожалуйста, избегайте его использования."

> **_12. функция restoreComment():_**
>
> - owner_id