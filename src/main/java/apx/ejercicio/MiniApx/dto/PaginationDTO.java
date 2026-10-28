package apx.ejercicio.MiniApx.dto;

public class PaginationDTO {

    private int page;
    private int pageSize;
    private int totalPages;
    private long totalElements;

    public PaginationDTO(int page,
                         int pageSize,
                         int totalPages,
                         long totalElements) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }
}