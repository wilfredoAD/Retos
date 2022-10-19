package com.reto3.reto3.Reports;

import com.reto3.reto3.model.Client;

public class CustomerCounter {
    private Long total;
    private Client client;

    public CustomerCounter(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
