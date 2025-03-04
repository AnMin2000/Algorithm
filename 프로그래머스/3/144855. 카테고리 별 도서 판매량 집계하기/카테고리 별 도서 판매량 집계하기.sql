# -- 코드를 입력하세요
SELECT CATEGORY, SUM(SALES) AS TOTAL_SALES
FROM BOOK A JOIN BOOK_SALES B
ON A.BOOK_ID = B.BOOK_ID
WHERE MONTH(SALES_DATE) = 1 AND YEAR(SALES_DATE) = 2022
GROUP BY CATEGORY
ORDER BY 1

