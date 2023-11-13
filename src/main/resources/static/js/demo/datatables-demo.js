// Call the dataTables jQuery plugin
$(document).ready(function() {
 $('#dataTable').DataTable({
   serverSide: true,
   ajax: {
     url: "/employee/list",
     type: "POST"
   },
   columns: [
     {data: "id"},
     {data: "name"},
     {data: "phone"},
     {data: "address"}
   ],
   order: [[ 0, "asc" ]], // initial order
   language: {
     lengthMenu: "페이지당 _MENU_ 개의 목록 표시",
     search: "제목 검색:",
     zeroRecords: "검색된 항목이 없습니다.",
     info: "전체 _PAGES_ 페이지 중 _PAGE_째 페이지",
     infoEmpty: "항목이 비었습니다.",
     infoFiltered: "(전체 _MAX_개의 항목에서 검색)",
     paginate: {
       previous: "이전",
       next: "다음"
     }
   }
 });
});

